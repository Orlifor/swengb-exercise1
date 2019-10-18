package fh.joanneum.swengb.lab1

import kotlin.math.PI

open class Shape(val color:String = "black") {
    open fun getArea():Double {
        return 0.0
    }
}
class Rectangle(color:String = "black", val width:Double = 1.0, val length:Double = 1.0): Shape(color){
    override fun getArea(): Double {   // make use of smart completion in IntelliJ (Alt+Enter), Ctrl+Space
        return width * length
    }

    override fun toString(): String {
        return "Rectangle(width=$width, length=$length,  color=$color)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rectangle

        if (width != other.width) return false
        if (length != other.length) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width.hashCode()
        result = 31 * result + length.hashCode()
        return result
    }
}

class Circle(color:String = "black", val radius:Double = 1.0): Shape(color){
    override fun getArea(): Double {   // make use of smart completion in IntelliJ (Alt+Enter), Ctrl+Space
        return radius * radius * PI
    }

    override fun toString(): String {
        return "Circle(radius=$radius, color=$color)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Circle

        if (radius != other.radius) return false

        return true
    }

    override fun hashCode(): Int {
        return radius.hashCode()
    }

}class Canvas() {
    private var shapes = mutableListOf<Shape>()

    fun addShape(shape: Shape) {
        shapes.add(shape)
    }

    fun getTotalArea(): Double {
        return shapes.sumByDouble { it.getArea() }
    }

    fun shapesCountPerType(): Map<String, Int> {
        return shapes.groupingBy { it.javaClass.simpleName }.eachCount()

    }

}
fun main() {
    val testShape = Shape()
    println(testShape.color) // black

    val testRectangle = Rectangle(width = 5.0, length = 2.0 )
    println(testRectangle.getArea()) // 10.0
    testRectangle.length // 2

    val testCircle = Circle(radius = 5.0)
    println(testCircle.getArea())

    val circle = Circle(radius = 10.0, color = "red")
    println(circle)  // fh.joanneum.swengb.lab1.Circle@266474c2

    val aShape: Shape = testRectangle
    val circle1 = Circle(radius = 10.0, color = "red")
    val circle2 = Circle(radius = 10.0, color = "red")

    println(circle1 === circle2) // false - checking referential integrity
    println(circle1 == circle2) // false - checking structural integrity
    println(setOf<Circle>(circle1, circle2).size) // 2 elements in the set

    println(aShape.getArea()) // 10.0

    val canvas = Canvas()
    canvas.addShape(Rectangle("white", width = 7.0, length = 2.0))
    canvas.addShape(Rectangle("blue", width = 7.0, length = 2.0))
    canvas.addShape(Rectangle("white", width = 5.0, length = 2.0))
    canvas.addShape(Circle("red", radius = 1.0))
    println(canvas.getTotalArea()) //  13.14
    println(canvas.shapesCountPerType())




}

