val l :Seq[Int] = Seq(1,2,3,4,5,6,7)

l.grouped(2).toList.foreach(e => println(e))
