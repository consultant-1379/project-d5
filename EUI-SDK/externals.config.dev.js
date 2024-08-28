const externals = {
  apps: [{
    path: "app-1",
    entry: "App1"
  }, {
    path: "my-app",
    entry: "MyApp"
  }, {
    path: "question-app",
    entry: "QuestionApp"
  }],
  components: {
    default: [],
    shareable: [{
      path: "lit-demo",
      entry: "LitDemo"
    }, {
      path: "template",
      entry: "Template"
    }, {
      path: "demo",
      entry: "Demo"
    }, {
      path: "chart-legend",
      entry: "ChartLegend"
    }, {
      path: "histogram-chart",
      entry: "HistogramChart"

    }, {
      path: "dialogs-component",
      entry: "DialogsComponent"
    }, {
      path: "radar-component",
      entry: "RadarComponent"


    }]
  },
  panels: [],
  plugins: []
};
module.exports = externals;
