package Find

import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option
import java.io.File
import java.lang.StringBuilder

fun main(args: Array<String>) {
    Find().createPath(args)
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
        if (!file.exists()) {
            println("Такой директории не существует!")
            return false
        }
        return file.isDirectory
    }

    private fun checkingFileExistence(directory: String, fileName: String, subDirectory: Boolean): Boolean {
        if (File(fileName) !in fileToList(File(directory)) && !subDirectory) {
            return true
        }
        return false
    }

    private fun directoriesResearch(file: File, fileName: String, subDirectory: Boolean,
                                    foundList: MutableList<String>): List<String> {
        for (element in fileToList(file)) {
            if (fileName in element.toString()) foundList.add(element.toString())
            if (isDirectoryCheck(element) && subDirectory) {
                directoriesResearch(element, fileName, subDirectory, foundList)
            }
        }
        return foundList
    }

    fun controlFindFile(file: File, fileName: String, subDirectory: Boolean,
                        foundList: MutableList<String>): List<String> {
        checkingFileExistence(directory, fileName, subDirectory)
        val list = directoriesResearch(file, fileName, subDirectory, foundList)
        if (foundList.isEmpty()) foundList.add("Такого файла не существует!")
        return list
    }

    private fun parser(args: Array<String>) {
        val parse = CmdLineParser(this)
        try {
            parse.parseArgument(*args)
        } catch (Exception: CmdLineException) {
            println("java -jar НазваниеJarФайлаПроектаFindUtility.jar [-r] [-d Directory] НазваниеФайла.txt")
        }
    }

    fun createPath(args: Array<String>) {
        parser(args)
        val foundList = mutableListOf<String>()
        val sb = StringBuilder()
        if (isDirectoryCheck(File(directory))) {
            for (path in controlFindFile(File(directory), file, subDirectory, foundList)) sb.append(path)
        }
        println(sb.toString())
    }

}