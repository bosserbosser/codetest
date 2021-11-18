#!/usr/bin/env scala

import scala.language.postfixOps
import util.{Try, Success, Failure}

val _vals = List(
    // base
    Try(1/1) == Success(1),
    Try(1/0).isInstanceOf[Failure[Any]],
    Try(1/1).isSuccess,
    Try(1/0).isFailure,
    // foreach
    { var sum = 0; Try(1/1) foreach (sum+=_); sum } == 1,
    { var sum = 0; Try(1/0) foreach (sum+=_); sum } == 0,
    // getOrElse
    ( Try(1/1) getOrElse 2 ) == 1,
    ( Try(1/0) getOrElse 2 ) == 2,
    // orElse
    ( Try(1/1) orElse Try(2) ) == Try(1),
    ( Try(1/0) orElse Try(2) ) == Try(2),
    // map
    ( Try(1/1) map (_*2) ) == Try(2),
    ( Try(1/0) map (_*2) ).isFailure,
    // match
    ( Try(1/1) match { case Success(x) => 2; case _ => -1 } ) == 2,
    ( Try(1/0) match { case Success(x) => 2; case _ => -1 } ) == -1,
)

for (data <- _vals) {
    assert(data)
}

