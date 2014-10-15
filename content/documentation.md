title=reqT Documentation
date=2014-08-01
type=page
status=published
~~~~~~
## Contents

* <a href="#hello"> Hello reqT </a>
* <a href="#intro"> Introduction to reqT</a>
* <a href="metamodel.html"> The reqT metamodel </a>
* <a href="#pub"> Publications and presentations </a>
* <a href="#diff"> Differences between reqT v3 and v2 </a>
* <a href="#old"> Old documentation for reqT v2 </a>

<hr/>

## <a id="hello"> Hello reqT </a>

* Download [reqT.jar](download.html) and run this command: `java -jar reqT.jar`
* Copy this "hello world" Model into the reqT console (paste with right click the press Enter):

        val m = Model(Feature("hi") has (Spec("hello world"), Prio(1))) 
        
    Type this to edit the model:    
        
        edit(m)

<hr/>        
## <a id="intro"> Introduction to reqT </a>

reqT is a scalable requirements modelling tool. With reqT you can create, edit, analyse and visualize requirements, ranging from very small models containing only a few sketchy elements to very large models with thousands of requirements. 

In reqT, requirements are represented in a textual language that enables you to, for example, paste models into emails, version-control your models using git or svn, store your models at GitHub or Bitbucket, and other things you normally do with code. 

### Creating reqT models

A reqT ```Model``` contains a sequence of elements. Elements can be one of the following three types:  

  * entities, such as ```Feature("x")``` or ```Stakeholder("a")```
  * attributes, such as ```Prio(1)``` or ```Spec("Hello reqT!")``` 
  * relations, such as ```Feature("x") has Prio(1)``` or ```Feature("x") requires Feature("y")```

Here is an example of a model that expresses different feature benefits according to two different stakeholders:

<iframe src="code/model-benefit.html" style="border-style:none; width:800px; height: 200px;"><pre class="prettyprint"><code class="lang-scala">Model(
  Stakeholder("Ada") has (
    Feature("export") has Benefit(4), 
    Feature("print") has Benefit(1), 
    Feature("upload") has Benefit(2)), 
  Stakeholder("Charles") has (
    Feature("export") has Benefit(2), 
    Feature("print") has Benefit(1), 
    Feature("upload") has Benefit(1)))
</code></pre></iframe>        
  
There are many different types of entities, attributes and relations, as listed [here](metamodel.html). You can use any combination of the available entities, attributes and relations as long as you follow these rules:  

  * An entity must have an id, e.g. ```Feature("myId")```.
  * An attribute must have a value of a specific type. 
      * String attributes must have a string, e.g. ```Spec("My detailed specification")``` or ```Gist("My short description.")```. 
      * Int attributes must have an integer, e.g. ```Prio(1)``` or ```Max(100)```. 
  * A relation must connect and entity with an element or a sequence of elements within parenthesis via a link of some relation type, e.g. the relation ```Feature("x") has Prio(1)``` connects a ```Feature``` entity with id "x" to a ```Prio``` attribute via a link of type ```has```.

### The reqT Scala-embedded DSL 
  
A requirements model in reqT is represented by a language that is embedded in [Scala](http://en.wikipedia.org/wiki/Scala_%28programming_language%29), a so called internal or embedded Domain-Specific Language [DSL](http://en.wikipedia.org/wiki/Domain-specific_language). This means that your models are represented using Scala classes in an efficient data structure that can be manipulated using concise and powerful Scala scripts.

The Scala class hierarchy of the Elem, Node, Relation, Attribute and Entity classes are shown below.

<img src="img/metamodel-simple.svg" alt="Elem class diagram"/> 

Elem is the superclass of Node and Relation. A Node can be either an Attribute or an Entity. A Relation has three value fields: entity, link and tail. The tail of a relation is a new Model that recursively can contain zero or more objects of type Elem.

You can check out the different available elements of the reqT metamodel [here](http://reqt.org/metamodel.html).

#### When to use which element of the reqT metamodel?

The reqT metamodel gives you a large bag of requirements-related concepts that you can combine freely in many different ways, as long as you follow some basic rules. What is a good or bad requirements model is determined by the context and there is no universal "truth" about the best way to model. However, here is some advice that you may want to follow:

  * Some parts of your requirements model may need to be more elaborated than other parts, as your requirements may be more or less risky to be badly implemented downstream.
  * If you work on modelling intentions (goals) and attach rationale (why) to your models, the risk for bad implementation is often reduced. Use the `Goal` entity and/or the `Why` attribute in your reqT models.
  * If you include examples in combination with intention and rationale, it is more likely that your models will be interpreted in a relevant way in downstream development. You can use the `Example` attribute, as shown in the model below with a feature that includes information on both goal (why), a product level specification, as well as an illustrative example:
<iframe src="code/model-why-spec-example.html" style="border-style:none; width:800px; height: 200px;"><pre class="prettyprint"><code class="lang-scala">Model(
  Feature("navigate") has (
    Why("Measuring neural response is a bit painful to the  patient. 
         Electrodes must be kept in place ... 
         So both hands should be at the patient during a measurement."),
    Spec("It shall be possible to perform the commands start, stop, 
          ... with both hands at the patient."),
    Example("Might be done with mini keyboard (wrist keys), foot pedal, 
            voice recognition, etc.")
  )
)
</code></pre></iframe>   
  
<hr/>
--- End of Introduction ---
<hr/>
## <a id="diff"> Differences between reqT v3 and v2 </a>

Version 3 of reqT is a complete rebuild from scratch and many things have been improved and generalized compared to v2, while some things still remains to be re-implemented (depending on user wishes). This section is intended for those who want to migrate old v2 reqT models, scripts and examples from old documentation to reqT v3.

The main differences between reqT v3 and v2 are:

* <b>Recursive Models</b>. The upper layers of the metamodel is generalized to allow for recursive entity-relation-attribute modelling where models can contain models of arbitrary depth. The old v2 special-case attribute Submodel is dropped and now *all* relations link to a submodel that recursively can contain attributes, entities and relations to submodels.
    Deprecated usage: 
        
        Model(Stakeholder("a") has Submodel(Feature("x") has Prio(1))) //this is old reqT v2
        
    Use this instead: 
    
        Model(Stakeholder("a") has (Feature("x") has Prio(1)))

 * <b>The has relation</b>. In v3 the has relation can connect any element to an entity including entities and relations, not only attributes. Thus the old v2 owns relation is dropped, as you can use the has relation instead in v3. In v2 the has relation is special as it only can link to attributes and the only way to connect attributes to entities in v2 is to use the has relation. 
    Deprecated usage: 
        
        Model(Product("p") owns Feature("x")) //this is old reqT v2
        
    Use this instead: 
    
        Model(Product("p") has Feature("x"))


* <b>New entities, relations and attributes.</b> The metamodel has undergone several changes. You can investigate the new medamodel using the new GUI, which is started using the ```edit``` command in the reqT console. In the GUI you can use the Metamodel menu to investigate the available elements.

* <b>Paths.</b> The forward slash operator / is used in v3 instead of the old bang operator ! to construct paths in a more intuitive way. Paths are also generalized to not just follow the has relation via the old Submodel attribute, but in v3 all paths can include a relation type, e.g. ```Stakeholder("a").requires/Feature("x").has/Prio``` 

* <b>Model operators.</b> The basic add operator + and the concatenate operator ++ works as before, but many of the other operators have been changed, removed or replaced by a named method. The old restrict operator / is now used for path construction. Instead the operator * is used as restrict operator with the semantic of recursively selecting any submodel that contains the right hand selector. You can see the implementation of model separator operators [here](https://github.com/reqT/reqT/blob/3.0.x/src/reqT/ModelSeparators.scala) and the implementation of the isMatch operator =*= [here](https://github.com/reqT/reqT/blob/3.0.x/src/reqT/DSL.scala).

* <b> Implementation using metaprogramming</b>. In v3 the metamodel of reqT is now expressed in reqT itself using the bootstrap entity Meta and the relation superOf. You can see the code of the metamodel <a href="https://github.com/reqT/reqT/blob/3.0.x/src/reqT/meta.scala#L18"> here </a>. The reqT metamodel is used to genrate Scala code that implements the entities, relations and attributes of the reqT DSL using Scala case classes, as seen in the generated code <a href="https://github.com/reqT/reqT/blob/3.0.x/src/reqT/GENERATED-metamodel.scala"> here </a>.

<hr/>
## <a id="pub"> Publications and presentations on reqT v2 </a>

The documents below explain the background of reqT and give examples of usage in reqT v2. Check out the <a href="#diff"> differences between reqT v3 and reqT v2 </a> before you try the examples in the below documents in reqT v3. If examples does not work it in v3 it is due to limitations in backward compatibility. 

<table>
<tr>
<td>reqT.org &ndash; Towards a Semi-Formal, Open and Scalable Requirements Modeling Tool</td>
<td><a href="http://reqt.org/reqT-REFSQ2013-paper.pdf" class="btn btn-success"><span class="glyphicon glyphicon-cloud-download"></span> Paper pdf </a> <a href="http://reqt.org/reqT-REFSQ2013-presentation.pdf" class="btn btn-success"><span class="glyphicon glyphicon-cloud-download"></span> Presentation pdf </a> <a href="http://reqt.org/reqT-REFSQ2013-presentation.pptx" class="btn btn-success"><span class="glyphicon glyphicon-cloud-download"></span> Presentation pptx </a> </td>
<td><a href="http://refsq.org/2013" class="btn btn-info"><span class="glyphicon glyphicon-link"></span> REFSQ2013 </a> </td>
</tr><tr>
<td>Flexible Requirements Modeling with reqT &ndash; a hands-on tutorial</td>
<td> <a href="http://reqt.org/reqT-siren2013.pdf" class="btn btn-success"><span class="glyphicon glyphicon-cloud-download"></span> Presentation pdf </a> </td>
<td><a href="http://sirensweden.org/SIREN/Signal13.html" class="btn btn-info"><span class="glyphicon glyphicon-link"></span> SiREN2013 </a> </td>
</tr><tr>
<td>reqT.org &ndash; A Scala DSL for Constraint-based Requirement Engineering using JaCoP</td><td> 
<a href="http://reqt.org/reqT-sweconsnet2013.pdf" class="btn btn-success"><span class="glyphicon glyphicon-cloud-download"></span> Presentation pdf </a> </td>
<td><a href="http://www.lth.se/index.php?id=70383" class="btn btn-info"><span class="glyphicon glyphicon-link"></span> SweConsNet2013 </a> </td>
</tr></table>

## <a id="old"> Old reqT v2 documents </a>

The documents below explain the background of reqT and give examples of usage in reqT v2. Check out the <a href="#diff"> differences between reqT v3 and reqT v2 </a> before you try the examples in the below documents in reqT v3. If an example does not work in v3, it is due to limitations in backward compatibility. 

[Old introduction to reqT v2](http://reqt.org/reqT-intro.pdf) 

[reqT v2 manual draft version 0.1](http://reqt.org/reqT-manual.pdf) 

[reqT v2 metamodel](http://reqt.org/metamodel.png) 

[reqT status promotion ladder](http://reqt.org/reqT-status.pdf) 

[reqT.css file for generated web documents](http://reqt.org/reqT.css) 