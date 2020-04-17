package find

import org.junit.Test
import kotlin.test.assertEquals

internal class FindTest {

    @Test
    fun test1() {
        val directory = "files4TestFind"
        val file = "watchList.txt"
        val subDirectory = false
        val assertPath = mutableListOf("files4TestFind\\watchList.txt")
        assertEquals(assertPath, Find().directoriesResearch(directory, file, subDirectory))
    }

    @Test
    fun test2() {
        val directory = "files4TestFind"
        val file = "file4Test.txt"
        val subDirectory = true
        val assertPath = mutableListOf("files4TestFind\\dedInside\\file4Test.txt")
        assertEquals(assertPath, Find().directoriesResearch(directory, file, subDirectory))
    }

    @Test
    fun test3() {
        val directory = "files4TestFind"
        val file = "kursOVT.txt"
        val subDirectory = false
        val assertPath = mutableListOf("files4TestFind\\kursOVT.txt")
        assertEquals(assertPath, Find().directoriesResearch(directory, file, subDirectory))
    }

    @Test
    fun test4() {
        val directory = "files4TestFind"
        val file = "=_=.txt"
        val subDirectory = true
        val assertPath = mutableListOf("files4TestFind\\=_=\\=_=.txt")
        assertEquals(assertPath, Find().directoriesResearch(directory, file, subDirectory))
    }

    @Test
    fun test5() {
        val directory = "files4TestFind"
        val file = "hidden.txt"
        val subDirectory = true
        val assertPath = mutableListOf("files4TestFind\\recursionCheck\\1\\2\\3\\hidden.txt")
        assertEquals(assertPath, Find().directoriesResearch(directory, file, subDirectory))
    }

    @Test
    fun test6() {
        val directory = "src"
        val file = "non.txt"
        val subDirectory = false
        val assertPath = emptyList<String>()
        assertEquals(assertPath, Find().directoriesResearch(directory, file, subDirectory))
    }

    @Test
    fun test7() {
        val directory = ""
        val file = "watchList.txt"
        val subDirectory = true
        val assertPath = mutableListOf("C:\\Users\\GamerPro\\IdeaProjects\\findUtility\\files4TestFind\\watchList.txt")
        assertEquals(assertPath, Find().directoriesResearch(directory, file, subDirectory))
    }

}
