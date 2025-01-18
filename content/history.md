title=reqT Old History
date=2014-08-01
type=page
status=published
~~~~~~

## This site is DEPRECATED. </br> Visit New site: <a href="https://reqt.github.io/">reqt.github.io</a>

New releases are published at [github.com/reqT/reqT/releases](https://github.com/reqT/reqT/releases) 

## reqT inception

The reqT development started in 2010 at <a href="http://serg.cs.lth.se/">Lund University</a> by Prof. <a href="http://cs.lth.se/bjornregnell">Björn Regnell</a>, to provide a free tool for illustrating essential requirements engineering concepts in software engineering teaching of MSc students. Since then reqT has grown into a comprehensive requirements engineering workbench and laboratory for capturing requirements modelling ideas based on experiences from practice and results from research.  

### Old releases

####[Version 3.1.x](http://reqt.org/reqT-v3.1.4.jar) 


* Release [3.1.7](http://reqt.org/reqT-v3.1.7.jar) Final 3.x release
* Release [3.1.4](http://reqt.org/reqT-v3.1.4.jar) update templates
* Release [3.1.3](http://reqt.org/reqT-v3.1.3.jar) move to Scala 2.12
* Release [3.1.2](http://reqt.org/reqT-v3.1.2.jar) add high dpi support
* Release [3.1.1](http://reqt.org/reqT-v3.1.1.jar) add server mode
* Release 3.1.0: bump to Scala 2.11.11
* Release 3.0.2: update docs

####[Version 3.0.1](http://reqt.org/reqT-v3.0.1.jar) 

2014-11-02: **Release 3.0.1**

* Improve graph generation and export including pdf, svg, png
* Add more graph layout managers in graph export
* Add html export including element type coloring and css
* Add latex export 
* Improve gui including example templates
* Improve iterators
* Add transform iterator
* Several bug fixes

####[Version 3.0.0](http://reqt.org/reqT-v3.0.0.jar)

2014-09-07: **Release 3.0.0**

* Graphical user interface with foldable tree view and syntax-colored text editor 
* Fully recursive modelling allowing models inside models at arbitrary depth
* New powerful Scala-embedded DSL and more comprehensive metamodel 
* Metamodel-aware auto-completion in text editor
* Export to graphviz, html, spreadsheet  and more
* New external DSL called *reqtext* using indentation instead of parenthesis 
* Meta-programming-enabled metamodel customization
* All required libs are included in a self-contained jar-file - no need to install Scala

####[Version 3.0.0-RC1](http://reqt.org/reqT-v3.0.0-RC1.jar)  

2014-08-01: Release Candidate 1 of version 3.0.0

* Rebuild from scratch
* Many new features (see notes on release 3.0.0 above)

### Even older versions <a href="http://reqt.org/old-site/" class="btn btn-warning btn-lg"><span class="glyphicon glyphicon-remove"></span> Visit old site </a> 

#### [Version 2.3](http://reqt.org/reqT-v2.3.jar) 
2014-01-26: *Constraint solving, hierarchy and variability*

* Add constraint solving by integration with JaCoP
* Add TestCase and Code and make runnable in REPL
* Add hierarchical model attribute and flattening of Submodel
* Add a first prototype of variability modelling

#### [Version 2.2](http://reqt.org/reqT-v2.2.jar) 
2012-11-29: *Improvements based on user requests*

* Restrict on sets of entities, e.g.: `m / (m / Label("aa")).sources`
* File proxy attribute External to load strings externally in toHtml, e.g.:
  `Feature("x") has (Gist("g"), External("myspecstring.txt",Spec.apply))`
* Escape sequence convertion from escape chars in toScala
* Newline `\n` in Attribute values is replaced with `<br>` in HTML-generation
* Cancelled bad code causing long execution times for large owns-structures 
* `m up Feature("x") == (m / Feature("x").up ++ (m \ Feature("x"))`
* `m down Feature("x") == (m / Feature("x").down ++ (m \ Feature("x"))`
* Semantic check of owns-relations: `m.hasMultiOwners, m.multiOwners`
* Semantic check of missing Specs: `m.hasMissingSpecs, m.missingSpecs`
* Ordering of Status and Level: `Status(DROPPED) < STATUS(ELICITED)`
* Check to run all (currently 2) available checks: `m.check`

#### [Version 2.1](http://reqt.org/reqT-v2.1.jar) 
2012-11-12: *Minor fixes + improved restrict operator*

  * you can now restrict models to general strings:


    m / "<find source entities containing this string>"
    m /+ "<find this string anywhere>"
    m /-> "<find destination entities containing this string>"
    ls     //list files in user.dir
    dir    // same as ls

    
    
  * Bug-fix on printing quotes in assigns:
  `Model(Class("Guest") assigns(Label("one-to-many")) to Class("Stay"))` 

#### [Version 2.0](http://reqt.org/reqT-v2.0.jar) 
2012-10-21: *Major update and refactoring*

* improved DSL with increased flexibility and applicability
* tight integration with Scala collections
* added document templates for flexible chapter control
* document generation focus on web instead of Latex
* type structure revised from scratch
* the data model is given a graph-like strukture
* relations are now generalized, and attributes have a "has"-edge
* A bit more idiomatic Scala
* ...
   - TODO Still to be backported: latex generation; but Html was more important

#### [Version 1.4](http://reqt.org/reqTv1.4.jar) 
2011-11-26: *prioOrder, custom chapter order by prio*
 * added operation prioOrder on domains:

     >   var d = Domain(feature("1", prio -> 2),feature("2",prio -> 1))
     >   d.prioOrder
     res3: List[reqT.Ent] = List(Ent(feature,2), Ent(feature,1))


     
 * chapter ordered based on chapter prio: 
 `d += chapter("x", text -> "my text", prio -> 3)` 
 * will place chapter("x") after all chapters with prio less than 3 and before all chapters with prio more than 3.
 * No prio is interpreted as `prio -> Int.MaxValue` 

#### [Version 1.3](http://reqt.org/reqTv1.3.jar) 
2011-11-26: *Custom chapters, changeAll with implicit deprecation*

 *  added entity chapter for latex chapter generation:
    d += chapter("My Chap", text -> "some text")
     d += chapter("My Chap") has (feature("x"),feature("y"))
 *  added changeAll to tranform an entity and make old key deprecated:
    d **= feature("x") -> goal("x1")
     // this will implicitly add a relation goal("x1") was feature("x")
     // and also change feature("x") to have gist -> "Deprecated." 
 *  improved latex generation
 *  added domain operations: related, unrelated, roots, leafs, intermediates

#### [Version 1.2](http://reqt.org/reqTv1.2.jar) 
2011-11-14: *Tabular export/import and bug fixes*

* no auto-creation/revision dates, delete attribute, intersect operator, tables in appendix, bugfix double text
* export to tabSep: 
     > d tabSep "test" // will save entities to test.txt as a tab separated table 
 * import from tabSep: 
     > importation.tabSep("infile.txt","outfile.scala","nameOfDomainVar") 
     > :load outfile.scala
 * remove attribute: 
     > d - creation   // will remove attribute creation from all entities in d
 * overview tables moved to appendix in latex generation
 * removed automatic creation and revision dates on student requests
 * new intersect operator:
     >  d1 & d2
     // gives a subdomain with all common keys and
     // Elements of d1 updated with attribute values of d2 if different 
 * bugfix: removed double generation of text attributes in latex

#### [Version 1.1](http://reqt.org/reqTv1.1.jar)
2011-11-14: *Settings, precondition, undefined, attribute removal*

    > d += setting("noTikz") //no tikz package included and no drawings
    > d += setting("latexPreamble", text -> "\\usepackage{graphics}") 
    > d += setting("noContext") //no context chapter generated
    > d += task("x", precondition -> "all x are true")
    > d.undefined //will give Set of all undefined Ent keys in relations
    > d += d.undefined //will add all undefined entities
    > d - feature("x", gist) //for removing single attributes

#### [Version 1.0](http://reqt.org/reqTv1.0.jar)  
2011-11-01: *First usage in teaching*

* Prototypical DSL structure in place
* Latex generation of specification and tikz generation of context diagram
* Illustrates requirements as entities, relations and attributes


