import kotlin.browser.document
import data.studentList
import react.dom.render

fun main(args: Array<String>) {
    render(document.getElementById("root")) {
        Lesson("Объектно - ориентированное программирование", studentList.toTypedArray())
    }
}