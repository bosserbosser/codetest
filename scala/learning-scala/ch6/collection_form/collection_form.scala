#!/usr/bin/env scala

import scala.util.Random
import scala.collection.immutable.HashSet
import scala.collection.immutable.TreeSet

val _vals = List[scala.collection.Iterable[Int]](
    HashSet.from(Range(0, 10)),
    TreeSet.from(Range(0, 10)),
    Range(0, 20).map(_ => Random.nextInt(10)).foldLeft(HashSet[Int]())((his,ele)=>his+ele),
    Range(0, 20).map(_ => Random.nextInt(10)).to(HashSet),
)

for (_val: Any <- _vals) {
    println(_val)
}

