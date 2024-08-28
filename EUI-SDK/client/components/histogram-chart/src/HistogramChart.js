/**
 * Component HistogramChart is defined as
 * `<e-histogram-chart>`
 *
 * Imperatively create component
 * @example
 * let component = new HistogramChart();
 *
 * Declaratively create component
 * @example
 * <e-histogram-chart></e-histogram-chart>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import { Histogram as EDSHistogram } from '@eds/vanilla/charts/histogram/Histogram';
import style from './histogramChart.css';
import '../../chart-legend/src/ChartLegend';

/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
@definition('e-histogram-chart', {
  style,
  home: 'histogram-chart',
  props: {
    propOne: { attribute: true, type: Boolean },
    propTwo: { attribute: true, type: String, default: 'Hello World' },
    data: { type: Object },
    config: { type: Object },
    markerData: { type: Array },
    hideLegend: { attribute: true, type: Boolean },
    liveData: { attribute: true, type: Boolean },
  },
})
export default class HistogramChart extends LitComponent {
  didUpgrade() {
    // observe changes in the e-histogram size.
    this.resizeObserver = new ResizeObserver(() => {
      this.chart.draw();
    });

    this.chart = new EDSHistogram({
      element: this.shadowRoot.getElementById('eds-chart'),
      data: this.data,
      ...this.config,
    });
    this.chart.init();

    // set the width of svg to 100% to fix resize issue...
    this.shadowRoot.querySelector('.chart').setAttribute('width', '100%');

    // destroy EDS onResize listened as we are using our own.
    this.chart.stage.destroy();

    // observe changes to the size of e-histogram-chart
    this.resizeObserver.observe(this);

    // initialize data markers
    if (this.markerData) {
      this.dataMarkers = new DataMarkers({
        markerData: this.markerData,
        chart: this.chart,
        scaleType: 'linear',
      });
      this.dataMarkers.init();
    }

    if (this.liveData) {
      // generate new values every 3 seconds to show live updates
      const timer = setInterval(() => {
        this.data.series[0].values = this._generateValues([
          {
            min: 20,
            max: 60,
            total: 500,
          },
        ]);
        this.data = { ...this.data };
        this.chart.draw(this.data);
      }, 3000);
    }
  }

  didConnect() {
    if (this.resizeObserver) {
      // observe changes to the size of e-histogram-chart
      this.resizeObserver.observe(this);
    }
  }

  didDisconnect() {
    if (this.resizeObserver) {
      // unobserve changes to the size of e-histogram-chart
      this.resizeObserver.unobserve(this);
    }
  }

  didChangeProps(changedProps) {
    // redraw the chart when the data changes...
    if (changedProps.has('data')) {
      this.chart.draw(this.data);
    }
  }

  _generateValues(arr) {
    const values = [];
    for (const bin of arr) {
      for (let n = 0; n < bin.total; n += 1) {
        values.push(Math.random() * (bin.max - bin.min) + bin.min);
      }
    }
    return values;
  }

  /**
   * @function highlight
   * @param {Chart} chart - EDS Chart instance
   * @param {String} name - name of the series to highlight in the chart
   */
  highlight(chart, name) {
    if (typeof chart._highlight === 'function') {
      chart._highlight(name);
    }
  }

  handleEvent(event) {
    if (event.type === 'legend:filter') {
      this.chart.draw(event.target.filter());
      this.highlight(this.chart);
    }
    if (event.type === 'legend:highlight') {
      this.highlight(this.chart, event.detail);
    }
    if (event.type === 'legend:highlight-off') {
      this.highlight(this.chart);
    }
  }

  /**
   * Render the <e-histogram-chart> component. This function is called each time a
   * prop changes.
   */
  render() {
    return html`<h1>Histogram Component</h1>
    
    <e-chart-legend
      @legend:filter=${this}
      @legend:highlight=${this}
      @legend:highlight-off=${this}
      ?hidden=${this.hideLegend}
      .data=${this.data}
    ></e-chart-legend>
    <div class='eds-chart' id='eds-chart'></div>
    `;
  }
}

/**
 * Register the component as e-histogram-chart.
 * Registration can be done at a later time and with a different name
 */
HistogramChart.register();
