import {fibonacci} from "./fibonacci.js";

export {stats, func}
const stats = []

const func = function (x) {
    return x - Math.log(x);
}

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

const lSlider = document.getElementById("l");
const lValue = document.getElementById("l-value");
lValue.innerHTML = lSlider.value;
lSlider.oninput = function() {
    lValue.innerHTML = this.value;
}


const btn = document.querySelector("button")

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
    } else {
        fibonacci(0.5, 4, Math.pow(10, -l), Math.pow(10, -4))
        createTable()
    }

    function notValidInput(str) {
        return (str === "" || isNaN(str) || str < 1 || str > 8)
    }
})
