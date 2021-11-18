
abstract class Notification
case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification

println("#### test1 ####")
def showNotification(notification: Notification): String = {
	notification match {
		case Email(email, title, _) =>
			s"You got an email from $email with title: $title"
		case SMS(number, message) =>
			s"You got an SMS from $number! Message: $message"
		case VoiceRecording(name, link) =>
			s"you received a Voice Recording from $name! Click the link to hear it: $link"
	}
}
val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
println(showNotification(someSms))
println(showNotification(someVoiceRecording))

println("#### test2 ####")
def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
	notification match {
		case Email(email, _, _) if importantPeopleInfo.contains(email) =>
			"You got an email from special someone!"
		case SMS(number, _) if importantPeopleInfo.contains(number) =>
			"You got an SMS from special someone!"
		case other =>
			showNotification(other) // nothing special, delegate to our original showNotification function
	}
}
val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")
val someSms_ = SMS("867-5309", "Are you there?")
val someVoiceRecording_ = VoiceRecording("Tom", "voicerecording.org/id/123")
val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
val importantSms = SMS("867-5309", "I'm here! Where are you?")
println(showImportantNotification(someSms_, importantPeopleInfo))
println(showImportantNotification(someVoiceRecording_, importantPeopleInfo))
println(showImportantNotification(importantEmail, importantPeopleInfo))
println(showImportantNotification(importantSms, importantPeopleInfo))

println("#### test3 ####")
abstract class Device
case class Phone(model: String) extends Device{
	def screenOff = "Turning screen off"
}
case class Computer(model: String) extends Device {
	def screenSaverOn = "Turning screen saver on..."
}
def goIdle(device: Device) = device match {
	case p: Phone => p.screenOff
	case c: Computer => c.screenSaverOn
}
val device1: Device = new Phone("mob1")
val device2: Device = new Computer("compt1")
println("device1 goIdle: " + goIdle(device1))
println("device2 goIdle: " + goIdle(device2))

