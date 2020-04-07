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

    @Option(name = "-r", metaVar = "RecursiveFlag", usage = "Поиск файл во всех поддиректориях")
    private val subDirectory = false

    @Option(name = "-d", metaVar = "DirectoryFlag", usage = "Поиск файла в текущей директории")
    private val directory = ""

    @Argument(required = true, metaVar = "FileName", usage = "Название нужного файла", index = 1)
    private val file = ""

    fun correctControl(args: Array<String>) {
        val parse = CmdLineParser(this)
        try {
            parse.parseArgument(*args)
        } catch (Exception: CmdLineException) {
            println("java -jar НазваниеJarФайлаПроектаFindUtility.jar [-r] [-d Directory] НазваниеФайла.txt")
        }
        val foundList = mutableListOf<String>()
        val directoryToFile = File(directory)
        if (directoryToFile.isDirectory) {
            for (path in RecursionFind.directoriesResearch(directoryToFile, file, subDirectory, foundList)) println(path)
        }
    }

}