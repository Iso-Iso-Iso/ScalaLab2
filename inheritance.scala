class Human(var name:String, var surname:String, var age:Int, var addr:Address) {
	private var _name = name 
	private var _surname = surname
	private var _age = age
	private var _addr = addr

	def Name:String = _name
	def Surname:String = _surname
	def Age:Int = _age
	def Addr:Address = _addr

	def showInfo():String = s"Name: $name \nAge: $age \nAddress: ${addr.country}, ${addr.city}"
}


class Address(var country:String, var city:String) {
	private var _country = country
	private var _city = city

	def Country:String = _country
	def City:String = _city
}


class Student(name:String, surname:String, age:Int, addr:Address, var group:String) extends Human(name, surname, age, addr) {
	private var _group = group

	def Group:String = _group

	override def showInfo():String = s"Name: $name \nAge: $age \nAddress: ${addr.country}, ${addr.city} \nGroup: $group"
}


class Teacher {
	private var listStudents:List[Student] = List()
	private var random = new scala.util.Random

	def AddNewStudent(student:Student):Unit = {
		listStudents = student :: listStudents
	}

	def PrintStudents():Unit = {
		listStudents.foreach(stud => println(s"Name: ${stud.name} \nSurname: ${stud.surname} \nAge: ${stud.age} \nAddress: ${stud.addr.country}, ${stud.addr.city} \nGroup: ${stud.group} \n"))
	}

	def RandomScore(student:Student):Unit = {
		println(s"${student.name}`s score: ${random.between(1, 6)}")
	}
}	


object Main {
	def main(args: Array[String]) = {

		var address1 = new Address("Ukraine", "Kyiv")
		var address2 = new Address("Ukraine", "Kherson")

		var teacher = new Teacher()
		var student1 = new Student("Vlad", "Bikov", 18, address1, "241")
		var student2 = new Student("Slava", "Gordkov", 20, address2, "343")
		
		teacher.AddNewStudent(student1)
		teacher.AddNewStudent(student2)
		
		teacher.PrintStudents()

		teacher.RandomScore(student1)
		teacher.RandomScore(student2)
	}
}