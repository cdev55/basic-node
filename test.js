console.log("Running tests...");

const result = 1 + 1;

if (result !== 2) {
  throw new Error("Test failed");
}

console.log("Tests passed!");