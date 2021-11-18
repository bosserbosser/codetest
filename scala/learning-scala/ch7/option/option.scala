#!/usr/bin/env scala

import scala.language.postfixOps

assert( Option(null) == Option.empty )
assert( Option.empty == None )
assert( Option(1) == Some(1) )
assert( Option(null).isEmpty )

// getOrElse
assert( (Some(1) getOrElse 2) == 1 )
assert( (None getOrElse 2) == 2 )

// orElse
assert( (Option(1) orElse Option(2)) == Some(1) )
assert( (None orElse Option(2)) == Some(2) )

// match
// assert( (Some(1) match { case Some(x) => x*2; case None => -1 }) == 2 )
assert( (Option(1) match { case Some(x) => x*2; case None => -1 }) == 2 )
//assert( ((Option(null): Option[Int]) match { case Some(x) => x*2; case None => -1 }) == -1 )
assert( ((None: Option[Int]) match { case Some(x) => x*2; case None => -1 }) == -1 )

