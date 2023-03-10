# Company Management
Dieses Projekt soll meinen Umgang mit einer Fullstack Anwendung repräsentieren. <br>
<br>
Wieso habe ich mir gerade dieses fachliche Projekt der Firmenverwaltung ausgesucht? <br>
Der Grund dafür ist, dass die Prozesse eines solchen Projektes leicht durchschaubar sind und dafür nicht besondere <br>
Kenntnisse in einem Bereich benötigt werden. <br>
Mir war es aber trotzdem wichtig, dass viele Module entstehen, welche Unternehmensprozesse abbilden.<br>
<br>
<br>
Austauschbarkeit der Infrastruktur:<br>
Nicht nur Frameworks oder Bibliotheken, sondern auch Technologien also sollen ohne Probleme austauschbar sein.<br>
Bei der Infrastruktur wird dies durch technische Definition in den einzelnen Subordnern und den deren resultierenden Docker Containern gewährleistet.<br>
<br>
Von den Containern werden services wie gateway oder auch queue bereitgestellt, hier wurde sich gegen eine<br> 
Benamung wie die direkte software entschieden also Kong oder RabbitMQ.<br>
<br>
Im backend, wird dann für die Austauschbarkeit eine hexagonale Architektur verwendet.<br> 
Das hat den Charm, dass ich auch auf Frameworks wie Micronaut oder Quarkus ausweichen kann.<br>
In der Zukunft ist auch geplant die genannten Rahmenwerke auszutauschen und einen Performancetest durchzuführen.<br>
<br>
<br>
<br>
<br>
<br>
<br>
Die Architektur der Anwendung sieht wie folgt aus.<br>
<br>
Es gab auch Services, welche ein Teil eines Schulprojekts waren. <br>
Diese Präsentation kann man ebenfalls unter dem docs Ordner finden.<br>