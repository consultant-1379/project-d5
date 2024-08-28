/**
 * Component RadarComponent is defined as
 * `<e-radar-component>`
 *
 * Imperatively create component
 * @example
 * let component = new RadarComponent();
 *
 * Declaratively create component
 * @example
 * <e-radar-component></e-radar-component>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import style from './radarComponent.css';

import { RadarChart } from '@eds/vanilla/charts/radar-chart/RadarChart';
global.lineData;
global.rCommon;
global.rValue;
global.average;
/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
@definition('e-radar-component', {
  style,
  home: 'radar-component',
  props: {
    propOne: { attribute: true, type: Boolean },
    propTwo: { attribute: true, type: String, default: 'Hello World' },
    data: { type: Object },

  },
})
export default class RadarComponent extends LitComponent {
  /**
   * Uncomment this block to add initialization code
   * constructor() {
   *   super();
   *   // initialize
   * }
   */

  /**
   * Render the <e-app-1> app. This function is called each time a
   * prop changes.
   */
  /**
   * lifecycle hook
   * @method didUpgrade
   */


_didConnect(){
  const storage = window.localStorage;
  const session = window.sessionStorage;
    let name =storage.getItem('username');

        let todo = {

                teamName:name

              };
              console.log("this is user name",name)
    fetch('http://localhost:9090/getResults', {
                    method: 'POST',
                    body: JSON.stringify(todo),
                    headers: { 'Content-Type': 'application/json' }
                  })

        .then((response) => {
          return response.json();
        }).then((json) => {
      global.rCommon =Object.keys(json);
      global.rValue = Object.values(json);

      global.average =(global.rValue.reduce((a, b) => a + b, 0))/9
      const test =(global.rValue.reduce((a, b) => a + b, 0))/9
      console.log("this is gloabal average value",global.average);
      console.log("this is gloabal test value",test);
      storage.setItem("average",global.average);
      global.lineData = {
        series: [{"name":"Cloud Materix","values":global.rValue},],
        common: global.rCommon,

      };


      this.data=global.lineData;

      this._loadRadarChart();

//      console.log("this is line value",global.rValue);
      //  console.log("this is data",global.rCommon);




    }).catch((error) => {
      console.log('parsing failed', error);
    });
  }

   didUpgrade() {

    this._didConnect();

  }

  _loadRadarChart() {

    // console.log('this is line data',this.data);
    const element = this.shadowRoot.querySelector('#radar');
    const radarchart = new RadarChart({
      element,
      data: this.data,
      colorScale: '#242424',
      height: 500,
      margin: {
        left: 20,
        bottom: 65,
      },
      y: {
        unit: 'Clound Matrix',
      },

      breakpoint: 400,
      tooltip: {
        format: {
          value: '.2f',
        },
        isHidden: false,
      },
    });

    radarchart.init();



  }


  render() {


    return html`


      <br/>


      <div class="radar-demo" id="radar" ></div>

      
      

      
    `;
  }
}

/**
 * Register the component as e-radar-component.
 * Registration can be done at a later time and with a different name
 */
RadarComponent.register();
