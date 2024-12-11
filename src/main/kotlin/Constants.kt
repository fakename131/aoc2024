import java.io.File
import kotlin.io.path.Path

const val _01_testInputs = """3   4
4   3
2   5
1   3
3   9
3   3"""
val _01_realInputs = file("01.txt").readText()
const val _02_testInputs = """7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9"""
val _02_realInputs = file("02.txt").readText()
const val _03_1_testInputs = """xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"""
const val _03_2_testInputs = """xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"""
val _03_realInputs = file("03.txt").readText()

fun file(res : String) : File = FileGetterSchlawg.file(res)

object FileGetterSchlawg {
    fun file(res : String) : File = Path(javaClass.getResource(res)?.path.toString()).toFile()
}