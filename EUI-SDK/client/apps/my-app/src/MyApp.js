/**
 * MyApp is defined as
 * `<e-my-app>`
 *
 * Imperatively create application
 * @example
 * let app = new MyApp();
 *
 * Declaratively create application
 * @example
 * <e-my-app></e-my-app>
 *
 * @extends {App}
 */
import { definition } from '@eui/component';
import { App, html } from '@eui/app';
import style from './myApp.css';
import '@eui/layout';
@definition('e-my-app', {
  style,
  props: {
    response: { attribute: false },
    data1: { type: Object },
    markerData1: { type: Array },
    data2: { type: Object },
    data3: { type: Object },
  },
})
export default class MyApp extends App {
  didConnect() {
    fetch('/datas')
        .then((response) => {
          return response.json();
        }).then((json) => {
      this.data1 = json.data1;
      this.markerData1 = json.markerData.markerData1;
      this.data2 = json.data2;

      // set initial value for live data chart - random values will be generated
      this.data3 = json.data3;
    }).catch((error) => {
      console.log('parsing failed', error);
    });
  }

  render() {
    return html`
      <div class='grid'>
        ${this.data1 && html`
        <eui-layout-v0-tile tile-title='Two series - Data Markers' subtitle='Server response time from device'>
          <e-histogram-chart
            slot='content'
            .data=${this.data1}
            .config=${{ x: { unit: 'milliseconds' } }}
            .markerData = ${this.markerData1}
          ></e-histogram-chart>
        </eui-layout-v0-tile>`}
        ${this.data2 && html`
        <eui-layout-v0-tile tile-title='Thresholds' subtitle='Gaussian distribution'>
          <e-histogram-chart
            slot='content'
            .data=${this.data2}
            .config=${{
      x: { unit: 'unit' },
      thresholds: [
        { moreThan: 35, color: 'green' },
        { lessThan: 10, color: 'red' },
      ],
    }}
          ></e-histogram-chart>
        </eui-layout-v0-tile>`}
        ${this.data3 && html`
        <eui-layout-v0-tile tile-title='Live Data Example' subtitle='with thresholds and cdf'>
          <e-histogram-chart
            live-data
            slot='content'
            .data=${this.data3}
            .config=${{
      x: { unit: 'unit' },
      thresholds: [
        { moreThan: 15, color: 'green' },
        { lessThan: 10, color: 'red' },
      ],
      cdf: true,
    }}
          ></e-histogram-chart>
        </eui-layout-v0-tile>`}
      </div>
    `;
  }
}

/**
 * Register the component as e-my-app.
 * Registration can be done at a later time and with a different name
 * Uncomment the below line to register the App if used outside the container
 */
 MyApp.register();
