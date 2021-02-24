import {fibonacci} from "./fibonacci.js";
import {golden} from "./golden.js";

export {stats, func}
const stats = []

const a = 0.5
const b = 4.0
const func = function (x) {
    return x - Math.log(x);
}

const functions = {
    //dichotomy: dichotomy,
    golden: golden,
    fibonacci: fibonacci,
    //parabola: parabola,
    //brent: brent,
}

let chosenFunction = functions.fibonacci;
let chosenFunctionName = "fibonacci"


// CHOSE METHODS
const methods = document.querySelectorAll(".methods li")
methods.forEach((method) => {
    method.addEventListener("click", function (e) {
        document.getElementById(chosenFunctionName).classList.remove("active")
        chosenFunctionName = e.target.id
        chosenFunction = functions[chosenFunctionName];
        method.classList.add("active")
    })
})


// CHOSE ACCURACY
const lSlider = document.getElementById("l");
const lValue = document.getElementById("l-value");
lValue.innerHTML = lSlider.value;
lSlider.oninput = function () {
    lValue.innerHTML = this.value;
}

const btn = document.querySelector("button")
const funcMin = document.getElementById("func-min")
const dotMin = document.getElementById("dot-min")
btn.addEventListener("click", function () {
    while (dataTable.firstChild) {
        dataTable.removeChild(dataTable.firstChild)
        stats.length = 0
    }
    const lInput = document.getElementById("l")
    const l = lInput.value
    if (notValidInput(l)) {
        lInput.value = ""
        alert("Invalid l value")
    } else if (typeof chosenFunction !== "function") {
        alert("No such method yet")
    } else {
        //fibonacci(0.5, 4, Math.pow(10, -l), Math.pow(10, -4))
        const res = chosenFunction(a, b, Math.pow(10, -l), Math.pow(10, -4))
        createTable()
        dotMin.innerText = res;
        funcMin.innerText = func(res)
    }

    function notValidInput(str) {
        return (str === "" || isNaN(str) || str < 1 || str > 8)
    }
})

// CREATING TABLE
const dataTable = document.querySelector(".datatable")
const tableHeaders = ["k", "a", "b", "b - a", "x1", "x2", "f1", "f2"]
const createTable = () => {
    let table = document.createElement('table')

    let tableHead = document.createElement('thead')
    tableHead.className = 'tableHead'

    let tableHeaderRow = document.createElement('tr')
    tableHeaderRow.className = 'tableHeaderRow'

    tableHeaders.forEach(header => {
        let scoreHeader = document.createElement('th')
        scoreHeader.innerText = header
        tableHeaderRow.append(scoreHeader)
    })
    tableHead.append(tableHeaderRow)
    table.append(tableHead)

    let tableBody = document.createElement('tbody')
    tableBody.className = "table-Body"

    stats.forEach(stat => {
        let row = document.createElement('tr')
        stat.forEach(cur => {
            let el = document.createElement("td")
            el.innerHTML = cur
            row.appendChild(el)
        })
        tableBody.appendChild(row)
    })
    table.append(tableBody)
    dataTable.append(table)
}
