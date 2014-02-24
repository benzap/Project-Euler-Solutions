(ns problem-002.core
  (:gen-class))

(def fib-seq 
  ((fn rfib [a b] 
     (lazy-seq (cons a (rfib b (+ a b)))))
   0 1))

(defn soln []
  (apply + (filter even? (take-while #(< % 4000000) fib-seq))))

(defn -main
  "problem 2 solution output"
  [& args]
  (soln))
