/**
 * Component ChartLegend is defined as
 * `<e-chart-legend>`
 *
 * Imperatively create component
 * @example
 * let component = new ChartLegend();
 *
 * Declaratively create component
 * @example
 * <e-chart-legend></e-chart-legend>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import style from './chartLegend.css';

/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
@definition('e-chart-legend', {
  style,
  home: 'chart-legend',
  props: {
    propOne: { attribute: true, type: Boolean },
    propTwo: { attribute: true, type: String, default: 'Hello World' },
    data: { type: Object, default: {} },
    hidden: { attribute: true, type: Boolean },
  },
})
export default class ChartLegend extends LitComponent {
  handleEvent(event) {
    if (event.type === 'click') {
      this.bubble('legend:filter', this.activePills);
      this.bubble('legend:highlight-off');
    }
    if (event.type === 'mouseenter') {
      if (!event.target.unselected) {
        this.bubble('legend:highlight', event.target.id);
      }
    }
    if (event.type === 'mouseleave') {
      this.bubble('legend:highlight-off');
    }
  }

  /**
   * Get all pills in the legend
   *
   * @property pills
   * @returns {Array} pills - array of pills in the legend
   */
  get pills() {
    if (this.shadowRoot) {
      return [...this.shadowRoot.querySelectorAll('eui-base-v0-pill')];
    }
    return [];
  }

  /**
   * Get active pills
   *
   * @property activePills
   * @returns {Array} activePills - Array of active pills in the legend
   */
  get activePills() {
    const active = this.pills.filter(pill => !pill.unselected);
    return active.map(element => element.id);
  }

  /**
   * Filter data based on pills selected state.
   *
   * @function filter
   */
  filter = () => {
    const filteredData = {};
    const dataCopy = JSON.parse(JSON.stringify(this.data));

    const active = this.activePills;
    filteredData.series = dataCopy.series.filter(element => active.includes(element.name));

    if (filteredData.series.length === 0) {
      filteredData.common = [];
    } else {
      filteredData.common = dataCopy.common;
    }
    return filteredData;
  }

  /**
   * Render the <e-chart-legend> component. This function is called each time a
   * prop changes.
   */
  render() {
    return html`<h1>Your component markup goes here</h1>
    

    <div class='euisdk-chart-legend'>
      ${this.data.series && this.data.series.map((pill, index) => html`
          <eui-base-v0-pill
            id=${pill.name}
            toggle
            icon='alarm-level6'
            color='var(--color-data-${index + 1})'
            @click=${this}
            @mouseenter=${this}
            @mouseleave=${this}
          >
            ${pill.name}
          </eui-base-v0-pill>
        `)}
    </div>
    
    `;
  }
}

/**
 * Register the component as e-chart-legend.
 * Registration can be done at a later time and with a different name
 */
ChartLegend.register();
