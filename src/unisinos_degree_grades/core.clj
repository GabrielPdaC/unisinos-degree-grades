(ns unisinos-degree-grades.core
  (:gen-class))

(defn read-number
  "Read a number from standard input.
   
   Parameters:
   - message - A string to be printed as a prompt for the user

   Returns:
   - [string] Representation of the number entered by the user.
    his function calculates the area of a rectangle."
  [message]
  (print message)
  (flush)
  (read-line))

(defn average
  "Calculate the average of two grades, considering that the second grade (gb) has a weight of 2.
  
  Args:
  - ga: First grade
  - gb: Second grade, that has weight of 2
  
  Returns:
  - [number] The avarge between two grades."

  [ga gb]
  (/ (+ ga (* 2.0 gb)) 3.0))

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

(defn -main []
  (let [ga (Float/parseFloat (read-number "Digite a nota do GA: "))
        gb (Float/parseFloat (read-number "Digite a nota do GB: "))
        avarage (average ga gb)
        needs-gc (needs-gc? avarage)]

    (println (format "A sua media foi: %.2f" avarage))
    (when needs-gc
      [(print (format "Voce precisa de grau C. A nota mais facil de recuperar e o grau %s" (easier-test-to-recover ga gb)))])))
