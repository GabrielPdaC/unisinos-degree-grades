(ns unisinos-degree-grades.core
  (:gen-class))

(defn read-number
  "Read a number from standard input.
   
   Parameters:
   - message - A string to be printed as a prompt for the user

   Returns:
   - [string] Representation of the number entered by the user.
    his function calculates the area of a rectangle."
  [print-function message]
  (print-function message)
  (flush)
  (Float/parseFloat (read-line)))

(defn average
  "Calculate the average of two grades, considering that the second grade (gb) has a weight of 2.
  
  Args:
  - ga: First grade
  - gb: Second grade, that has weight of 2
  
  Returns:
  - [number] The avarge between two grades."

  [ga gb]
  (/ (+ ga (* 2.0 gb)) 3.0))

(defn average-vector 
  "Calculate the average of a vector of grades.
  
  Args:
  - vector: Grades
  
  Returns:
  - [number] The avarge between all grades."
  
  [vector]
  (/ (reduce + vector) (count vector)))

(defn needs-gc?
  "Determines if a student needs to take a make-up exam based on their average score.
  
  Args:
  - average: The student's average score
  
  Returns:
  - [boolean] True if the average score is less than 6, indicating that the student needs to take a make-up exam. Returns false otherwise."
  [avarage]
  (< avarage 6))

(defn easier-test-to-recover
  "Determines wich test is easier to recover.
  
  Args:
  - ga: First grade
  - gb: Second grade, that has weight of 2
  
  Returns:
  - [string] Letter that represent the easier test grade to recover."

  [ga gb]
  (let [ga-needed (- 18 (* 2 gb))
        gb-needed (/ (- 18 ga) 2)
        ga-easier (< ga-needed gb-needed)]
    (if ga-easier
      "A"
      "B")))

(defn main-loop 
  "Loop to collect the grades
   
   Args:
   - index: Grade of
   
   Returns
   - [number] Average"
  [index]
  (let [ga (read-number print (format "\n\nDigite a nota do aluno %d GA: " index))
        gb (read-number print (format "Digite a nota do aluno %d GB: " index))
        average (average ga gb)
        needs-gc (needs-gc? average)]

    (println (format "A media do aluno foi: %.2f" average))
    (if needs-gc
      [(println "O aluno precisa de grau C.")
       (print (format "A prova mais facil de recuperar e o grau %s" (easier-test-to-recover ga gb)))]
      (print "Parabens, aluno aprovado!"))
    average))

(defn -main [] 
  (let [ grades (loop [i 0 v []]
           (if (< i 5)
             (recur (inc i) (conj v (main-loop (+ i 1))))
             v))]
    (print (format "\n\nA media da turma foi: %.2f" (average-vector grades)))))