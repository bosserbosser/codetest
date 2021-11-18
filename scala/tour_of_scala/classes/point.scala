
import math.sqrt

class Point(var x:Int, var y:Int) {
	private val square = (x:Int) => x*x
	def move(dx:Int, dy:Int) : Unit = {
		x += dx
		y += dy
	}
	def distance(ax:Int, ay:Int) : Double = sqrt(square(x-ax) + square(y-ay))
	override def toString() : String = {
		s"($x,$y)"
	}
}

val point1 = new Point(1,2)
println(point1)
println(point1.distance(0,0))
point1.move(2,2)
println(point1)
println(point1.distance(0,0))

