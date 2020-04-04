package Find

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

internal class FindTest {

    @Test
    fun test1() {
        val directory = File("files4TestFind")
        val file = "watchList.txt"
        val subDirectory = true
        val assertPath = mutableListOf("files4TestFind\\watchList.txt")
        val foundFile = mutableListOf<String>()
        assertEquals(assertPath, RecursionFind.directoriesResearch(directory, file, subDirectory, foundFile))
    }

    @Test
    fun test2() {
        val directory = File("src")
        val file = "file4Test.txt"
        val subDirectory = true
        val assertPath = mutableListOf("src\\file4Test.txt")
        val foundFile = mutableListOf<String>()
        assertEquals(assertPath, RecursionFind.directoriesResearch(directory, file, subDirectory, foundFile))
    }

    @Test
    fun test3() {
        val directory = File("files4TestFind")
        val file = "kursOVT.txt"
        val subDirectory = true
        val assertPath = mutableListOf("files4TestFind\\kursOVT.txt")
        val foundFile = mutableListOf<String>()
        assertEquals(assertPath, RecursionFind.directoriesResearch(directory, file, subDirectory, foundFile))
    }

    @Test
    fun test4() {
        val directory = File("files4TestFind")
        val file = "=_=.txt"
        val subDirectory = true
        val assertPath = mutableListOf("files4TestFind\\=_=\\=_=.txt")
        val foundFile = mutableListOf<String>()
        assertEquals(assertPath, RecursionFind.directoriesResearch(directory, file, subDirectory, foundFile))
    }

    @Test
    fun test5() {
        val directory = File("src")
        val file = "hidden.txt"
        val subDirectory = true
        val assertPath = mutableListOf("src\\recursionCheck\\1\\2\\3\\hidden.txt")
        val foundFile = mutableListOf<String>()
        assertEquals(assertPath, RecursionFind.directoriesResearch(directory, file, subDirectory, foundFile))
    }

    @Test
    fun test6() {
        val directory = File("src")
        val file = "non.txt"
        val subDirectory = false
        val assertPath = mutableListOf("Такого файла не существует!")
        val foundFile = mutableListOf<String>()
        assertEquals(assertPath, RecursionFind.directoriesResearch(directory, file, subDirectory, foundFile))
    }

}
