<h1> Emeline DIEU, Thomas MOREAU , Projet Questionnaire </h1>

<h3> Introduction au projet </h3>
<p> Le projet à réaliser était un questionnaire à créer à l'aide de fichiers textes</p>

<p> Le projet était à réaliser en deux temps : dans un premier temps, un mode texte nous a été demandé, puis un mode graphique a été réalisé</p>

<p> Le sujet nous demandait des connaissances techniques sur la conception orientée objet, nous avons utilisé le principe d'héritage, ainsi que les types génériques, le design pattern Factory ou encore les tests.</p>

<h3> How to </h3>
<p><em>Récuperation du projet : </em> git clone git@gitlab-etu.fil.univ-lille1.fr:dieu/Projet_Questionnaire_Moreau_Dieu.git</p>

<p><em>Commande génération de la documentation : </em> <strong> cd Projet_Questionnaire_Moreau_Dieu/</strong> puis <strong> mvn javadoc:javadoc </strong> , la javadoc se trouve dans le dossier target/docs/ </p>

<p><em>Commande de génération du projet : </em>  mvn package </p>

<p> <em>Commande de l'execution de l'archive générée : </em> java -jar target/Projet_Questionnaire_Moreau_Dieu-1.0-SNAPSHOT.jar

<p> Pour ce projet,  l'UML a été réalisé, les consignes ont été respectées, toutes les fonctionnalités demandées dans le cahier des charges sont implémentées. </p>

<p> Nous avons utilisé pour les classes de tests des méthodes de création d'objets abstraits comme vu en TD</p>
<p>Toutes les fonctionnalités testables du projet ont été testées. </p>

<p> Nous n'avons pas rencontré de problèmes particuliers, nouos avons eu l'occasion de traiter les types génériques dans d'autres projets, l'utilisation de la classe Class nous a été facilitée grâce au TD à ce sujet.</p>

<p> Voici l'UML en plusieurs parties du projet </p>

<h4> Le package Answer </h4>

![alt tag](https://gitlab-etu.fil.univ-lille1.fr/dieu/Projet_Questionnaire_Moreau_Dieu/uploads/5abc58ec5ffc5ed665fd46ac7e926f3b/packageAnswer.png)

<p> C'est dans ce package que nous avons créés les différents types de réponses, en utilisant une classe Abstraite Answer ainsi qu'une AnswerFactory (utilisation du design pattern Factory). </p>
<p> Ce package contient toutes les verifications concernants les réponses données par l'utilisateur, la réponse en elle même et son type.</p>

<h4> Le package Views </h4>

![alt tag](https://gitlab-etu.fil.univ-lille1.fr/dieu/Projet_Questionnaire_Moreau_Dieu/uploads/f4f1ae614c79c509c483cb2bfcba894b/packageViews.png)

<p> C'est le package qui gère l'Interaction Homme Machine avec les différents types d'élements à ajouter au panel principal pour représenter le questionnaire complet.</p>

<h4> Le package Questionnaire </h4>

![alt tag](https://gitlab-etu.fil.univ-lille1.fr/dieu/Projet_Questionnaire_Moreau_Dieu/uploads/422b101033f4a6b197766387f82a7a3b/packageQuestionnaire.png)

<p> C'est le package qui gère la classe principale du projet, le Main.</p>
<p> Le main permet de lancer soit le questionnaire en graphique, soit en mode texte selon le choix de l'utilisateur </p>
<p> Ce package regroupe la lecture du fichier texte, la création du questionnaire, les méthodes liées à ce dernier ainsi qu'une factory de Questionnaire </p>
