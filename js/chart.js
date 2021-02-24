
const ctx = document.getElementById('myChart');

let data = {
    labels: Array.apply(null, {length : 50}).map(Number.call,Number).map(el => (0.1 * el).toFixed(2)),
    datasets: [{
        label: "f(x) = x - ln(x)",
        function: function(x) { return x - Math.log(x) },
        borderColor: "rgba(75, 192, 192, 1)",
        data: [],
        fill: false
    }]
};

Chart.plugins.register({
    beforeInit: function (chart) {
        let data = chart.config.data;
        for (let i = 0; i < data.datasets.length; i++) {
            for (let j = 0; j < data.labels.length; j++) {
                let fct = data.datasets[i].function,
                    x = data.labels[j],
                    y = fct(x);
                data.datasets[i].data.push(y);
            }
        }
    }
})

const myChart = new Chart(ctx, {
    type: 'line',
    data: data,
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    min: 0.5,
                    stepSize: 0.25
                },
            }]
        }
    }
});