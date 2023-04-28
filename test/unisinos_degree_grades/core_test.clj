(ns unisinos-degree-grades.core-test
  (:require [clojure.test :refer :all]
            [unisinos-degree-grades.core :refer :all]))

(deftest average-test
  (testing "Teste com números inteiros"
    (is (= (average 3 5) (/ 13 3))))
  (testing "Teste com números inteiros" 
    (is (= (average 10 10) 10)))
  (testing "Teste com números inteiros" 
    (is (= (average 6.2 8.1) (/ 22.4 3))))
  (testing "Teste com números inteiros"
    (is (= (average 6 6) (/ 18 3))))
  (testing "Teste com números inteiros"
    (is (= (average 620 810) (/ 2240 3))))
  )
(deftest needs-gc?-test
  (is (= 1 1)))