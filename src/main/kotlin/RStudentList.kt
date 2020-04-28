import data.Student
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface RSProps : RProps {
    var Rstudents: Array<Student>
    var Rpresence: Array<Boolean>
    var RonClick: (Int) -> (Event) -> Unit
}

val RFStudentList =
    functionalComponent<RSProps> { props ->
        ol {
            props.Rstudents.mapIndexed { index, student ->
                RStudent(student, props.Rpresence[index], props.RonClick(index))
            }
        }
    }


fun RBuilder.studentList(students: Array<Student>, presence: Array<Boolean>, onClick: (Int) -> (Event) -> Unit) =
    child(RFStudentList) {
        attrs.Rstudents = students
        attrs.Rpresence = presence
        attrs.RonClick = onClick
    }