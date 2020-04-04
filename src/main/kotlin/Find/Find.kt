package Find

import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option
import java.io.*

fun main(args: Array<String>) {
    Find().correctControl(args)
    Find().createPath()
}

class Find {

    @Option(name = "-d", usage = "Поиск файла в текущей директории")
    private val directory = File("")

    @Option(name = "-r", usage = "Поиск файл во всех поддиректориях")
    private val subDirectory = false

    @Argument(required = true, usage = "Название нужного файла")
    private val file = ""

    fun correctControl(args: Array<String>) {
        val parse = CmdLineParser(args)
        try {
            parse.parseArgument(*args)
        } catch (Exception: CmdLineException) {
            println("java -jar НазваниеJarФайлаПроектаFindUtility.jar -r -d Directory НазваниеФайла")
        }
    }

    fun createPath() {
        val foundList = mutableListOf<String>()
        if (directory.isDirectory) {
            for (path in RecursionFind.directoriesResearch(directory, file, subDirectory, foundList)) println(path)
        }
    }

}