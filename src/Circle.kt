package fh.joanneum.swengb.lab1

class Circle(color:String = "black", val radius:Double = 1.0): Shape(color){
    override fun getArea(): Double {
        return radius * radius * Math.PI
    }
    override fun toString(): String {
        return "Circle(radius=$radius, color=$color)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Circle) return false
        if (!super.equals(other)) return false

        if (radius != other.radius) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + radius.hashCode()
        return result
    }


}