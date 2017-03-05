val textFile = sc.textFile("/tmp/hemant/TitanicData.txt")
val split = textFile.filter { x => {if(x.toString().split(",").length >= 6) true else false} }.map(line=>{line.toString().split(",")})
val count=split.map(x=>(x(1)+" "+x(4)+" "+x(6)+" "+x(2),1)).reduceByKey(_+_).collect
