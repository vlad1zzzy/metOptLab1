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

const btn = document.querySelector("button")

btn.addEventListener("click", function () {
    while (dataTable.firstChild) {
        dataTable.removeChild(dataTable.firstChild)
    }
    const lInput = document.getElementById("l")
    const l = lInput.value
    const epsInput = document.getElementById("eps")
    const eps = epsInput.value
    if (l === "" || eps === "" || isNaN(l) || isNaN(eps) || l >= 1 || eps >= 1) {
        lInput.value = ""
        epsInput.value = ""
        alert("Invalid l or eps")
    } else {
        fibonacci(0.5, 4, l, eps)
        createTable()
    }
})
