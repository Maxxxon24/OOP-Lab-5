import data.Student
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface RListProps : RProps {
    var work: String
    var student: Array<Student>
}

interface RWorkState : RState {
    var presence: Array<Boolean>
}

class WorkClass : RComponent<RListProps, RWorkState>() {
    override fun componentWillMount() {
        state.apply {
            presence = Array(props.student.size) { false }
        }
    }

    fun onClick(): (Int) -> (Event) -> Unit =
        { index: Int ->
            {
                setState {
                    presence[index] = !presence[index]
                }
            }
        }

    override fun RBuilder.render() {
        h2 { +"Занятие: \"${props.work}\"" }
        studentList(props.student, state.presence, onClick())
    }
}

fun RBuilder.Lesson(header: String, student: Array<Student>) =
    child(WorkClass::class) {
        attrs.work = header
        attrs.student = student
    }