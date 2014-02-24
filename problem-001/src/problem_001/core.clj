(ns problem-001.core
  (:gen-class))

(defn cond-three-five [num]
  "returns true if it's a multiple of 3 or 5"
  (or (zero? (mod num 3))
      (zero? (mod num 5))))

(cond-three-five 5)

(defn soln []
  (apply + (filter cond-three-five (take 1000 (range)))))

(defn -main
  [& args]
  (soln))
