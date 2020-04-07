package Find

import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option
import java.io.*

fun main(args: Array<String>) {
    Find().correctControl(args)
}

class Find {

    @Option(name = "-r", usage = "Поиск файл во всех поддиректориях")
    private var subDirectory = false

    @Option(name = "-d", usage = "Поиск файла в текущей директории")
    private var directory = ""

    @Argument(required = true, usage = "Название нужного файла")
    private var file = ""

    private fun fileToList(file: File): Array<File> {
        val fileList = file.listFiles()
        if (fileList != null) return fileList
        return emptyArray()
    }

    private fun isDirectoryCheck(file: File): Boolean {
        return file.isDirectory
    }

    private fun checkingFileExistence(file: File, fileName: String, subDirectory: Boolean): Boolean {
        if (fileName !in fileToList(file).map { it.toString() } && !subDirectory) {
            println("Такого файла не существует!")
            return true
        }
        return false
    }

    fun directoriesResearch(
        file: File, fileName: String, subDirectory: Boolean,
        foundList: MutableList<String>): List<String> {
        if (checkingFileExistence(file, fileName, subDirectory)) return emptyList()
        for (element in fileToList(file)) {
            if (fileName in element.toString()) foundList.add(element.toString())
            if (isDirectoryCheck(element) && subDirectory) {
                directoriesResearch(element, fileName, subDirectory, foundList)
            }
        }
        return foundList
    }

    fun correctControl(args: Array<String>) {
        val parse = CmdLineParser(this)
        try {
            parse.parseArgument(*args)
        } catch (Exception: CmdLineException) {
            println("java -jar НазваниеJarФайлаПроектаFindUtility.jar [-r] [-d Directory] НазваниеФайла.txt")
        }
        val foundList = mutableListOf<String>()
        if (isDirectoryCheck(File(directory))) {
            for (path in directoriesResearch(File(directory), file, subDirectory, foundList)) println(path)
        }
    }

}