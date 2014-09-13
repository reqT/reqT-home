//run this scala script using this command in terminal:
//  scala -classpath "/Users/bjornr/reqT/lib/reqT.jar" genmeta.scala

import reqT._

println("*** Generating metamodel.md text file")

def ids(m: Model, indent: String=""): String = m.toVector.collect {
  case Relation(ent, link, tail) => s"$indent* ${ent.id}\n" + ids(tail, indent+(" "*4))
  case ent: Entity => s"$indent* ${ent.id}\n"
}.mkString

def ents = ids(reqT.meta.model / Meta("Entity").superOf)

def attrs = ids(reqT.meta.model / Meta("Attribute").superOf)

def rels = ids(reqT.meta.model / Meta("RelationType").superOf)

s"""title=reqT Metamodel
date=2014-09-13
type=page
status=published
~~~~~~
## Contents

* <a href="#ents"> Entity types </a>
* <a href="#attrs"> Attribute types </a>
* <a href="#rels"> Relation types </a>

<hr/>

### <a id="ents"> Entity types </a>

$ents 

### <a id="attrs"> Attribute types </a>

$attrs 

### <a id="rels"> Relation types </a>

$rels 
""".save("content/metamodel.md")