
val numPattern = "[0-9]".r

numPattern.findFirstMatchIn("abc1def2") match {
	case Some(_) => println("password ok")
	case None => println("password must contain a number")
}

