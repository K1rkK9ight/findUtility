package find

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

    private fun directoryControl(directory1: String): String {
        if (directory1.isEmpty()) return File("src").absolutePath
        return directory1
    }

    fun directoriesResearch(directory2: String, fileName: String, subDir: Boolean,
                                    researchList: MutableList<String>): List<String> {
        val rlyFile = File(directoryControl(directory2))
        for (element in rlyFile.listFiles()!!) {
            val elem = element.toString()
            if (fileName in elem) researchList.add(elem)
            if (element.isDirectory && subDir) {
                directoriesResearch(elem, fileName, subDir, researchList)
            }
        }
        return researchList
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
        val list4Path = mutableListOf<String>()
        val sb = StringBuilder()
        val directoryChecked = directoryControl(directory)
        val fileDirectory = File(directoryChecked)
        var count = 0
        if (!fileDirectory.exists()) {
            println("Такой директории не существует!")
            count++
        }
        if (fileDirectory.isDirectory) {
            for (path in directoriesResearch(directoryChecked, file, subDirectory, list4Path)) {
                if (file in path) {
                    sb.append(path)
                    sb.append(" ")
                }
                else sb.append(path)
            }
        }
        if (sb.isEmpty() && count == 0) println("Такого файла не существует!")
        println(sb.toString())
    }

}