/**
 * Component Demo is defined as
 * `<e-demo>`
 *
 * Imperatively create component
 * @example
 * let component = new Demo();
 *
 * Declaratively create component
 * @example
 * <e-demo></e-demo>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import style from './demo.css';
import 'whatwg-fetch';
// eslint-disable-next-line import/order
import '@eui/table';



function ChangeProgress(demo) {
  console.log('update progressbar value ')
  fetch('/value')
      .then(function(response) {
        return response.json()
      }).then(function(json) {
    demo.pValue = json.pValue
    console.log('parsed json ', json)
  }.bind(this)).catch(function(ex) {
    console.log('parsing failed', ex)
  })
}

/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {Boolean} propTwo - shows the "Hello World" string.
 */
@definition('e-demo', {
  style,
  home: 'demo',
  props: {
    propOne: { attribute: true, type: Boolean, default: false },
    propTwo: { attribute: true, type: Boolean, default: false },
    buttonDisabled:{attribute: false, type: Boolean, default: false },
    pValue:{ attribute: true, type: Number,default: 10 },
  },
})
export default class Demo extends LitComponent {
  /**
   * Render the <e-demo> component. This function is called each time a
   * prop changes.
   */

  /**
   * Render the <e-greeting-message> component. This function is called each time a
   * prop changes.
   */
  render() {

    const columns = [
      { title: 'Stage', attribute: 'No Process' },
      { title: 'Waterfall', attribute: 'Agile' }
    ];
    const data = [
      { col1: 'Details 1', col2: 'Details 1'},
      { col1: 'Details 2', col2: 'Details 2'},
      { col1: 'Details 3', col2: 'Details 3'},
    ];

    return html`<h1>Your component markup goes here</h1>
    <h2>Culture</h2>

      <eui-table-v0 .columns=${columns} .data=${data}></eui-table-v0>


`;
  }

}

/**
 * Register the component as e-demo.
 * Registration can be done at a later time and with a different name
 */
Demo.register();
