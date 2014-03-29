(ns problem-014.core
  (:gen-class))

(defn even-function [num]
  (/ num 2))

(defn odd-function [num]
  (+ (* 3 num) 1))

(defn collatz [num]
  (cond
   (even? num) (even-function num)
   :else (odd-function num)))

(defn collatz-list [x]
  (loop [val x
         collatz-seq [x]]
    (if (= 1 val)
      collatz-seq
      (recur (collatz val)
             (conj collatz-seq (collatz val))))))

(collatz-list 13)



(loop [i 0
       x []]
  (if-not (< (count x) 10)
    x
    (recur (inc i) (conj x (inc i)))))

(defn soln []
  (max-key count (map (fn [x] collatz-list (range 1000000)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
