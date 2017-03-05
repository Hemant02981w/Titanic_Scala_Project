val textFile = sc.textFile("/tmp/hemant/TitanicData.txt")
val split = textFile.filter { x => {if(x.toString().split(",").length >= 6) true else false} }.map(line=>{line.toString().split(",")})
val key_value = split.filter{x=>if((x(1)=="1")&&(x(5).matches(("\\d+"))))true else false}.map(x => {(x(4),x(5).toInt)})
key_value.mapValues((_, 1)).reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2)).mapValues{ case (sum, count) => (1.0 * sum)/count}.collectAsMap()
