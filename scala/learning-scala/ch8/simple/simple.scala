#!/usr/bin/env scala

import scala.language.postfixOps

class Person(_id: Long, _name: String, _age: Int, val sex: Boolean, var height: Int) {
    val id = _id
    def name = _name
    var age = _age
    override def toString = {
        s"Person[id=${id}, name=$name, age=$age, sex=$sex, height=$height]"
    }
}

val p = new Person(_id=1, _name="bosser", height=165, _age=29, sex=true)

println(p)

p.age += 1
p.height += 3

println(p)

