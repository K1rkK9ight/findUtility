package Find

import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option


class Parser internal constructor(commandLine: String) {
    @Option(name = "-r", metaVar = "RecursiveFlag", usage = "Поиск файл во всех поддиректориях")
    private val subDirectory = false

    @Option(name = "-d", metaVar = "DirectoryFlag", usage = "Поиск файла в текущей директории")
    private val directory = ""

    @Argument(required = true, metaVar = "FileName", usage = "Название нужного файла", index = 1)
    private val file = ""

    init {
        val splitArgs = commandLine.split(" ").toTypedArray()
        val parser = CmdLineParser(this)
        try {
            parser.parseArgument(*splitArgs)
        } catch (ex: CmdLineException) {
            println(ex.message)
        }
    }
}
