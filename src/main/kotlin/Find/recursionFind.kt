package Find

import java.io.*

object RecursionFind {

    private fun fileToList(file: File): Array<File> {
        return file.listFiles()!!
    }

    fun directoriesResearch(
        file: File, fileName: String, subDirectory: Boolean,
        foundList: MutableList<String>): List<String> {
        val fileList = fileToList(file)
        if (fileName !in fileList.map { it.toString() } && !subDirectory) {
            foundList.add("Такого файла не существует!")
            return foundList
        }
        for (element in fileList) {
            if (fileName in element.toString()) foundList.add(element.toString())
            if (element.isDirectory && subDirectory) {
                directoriesResearch(element, fileName, subDirectory, foundList)
            }
        }
        return foundList
    }

}