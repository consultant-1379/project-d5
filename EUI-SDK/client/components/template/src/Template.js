
import { TemplateComponent, definition } from "@eui/component";
import style from "./template.css";
import template from "./template.html";
import { HorizontalBarChart } from '@eds/vanilla/charts/bar-charts/HorizontalBarChart';
@definition("template-component", {
    style,
    template,
    props: {
        data: { type: Object },
    },
})
export default class MyComponent extends TemplateComponent {
    constructor() {
        super();

        // Declaration of selectors

    }

    didConnect() {
        // Subscribe on event listeners and observers

        // example of setting prop on Component...
        this._loadChart();
    }

    didDisconnect() {
        // Unsubscribe from all event listeners and observers
    }

    _loadChart() {
        const elem = this.shadowRoot.querySelector('.chart');
        if (this.data) {
            const chart = new HorizontalBarChart({
                element: elem,
                data: this.data,
                thresholds: [
                    {
                        moreThan: 600,
                        color: 'red',
                    },
                    {
                        lessThan: 200,
                        color: 'green',
                    },
                ],
                x: {
                    unit: 'Alarms',
                },
            });
            chart.init();
        }
    }


    didRender() {
        // Actions which should be executed after any render
    }
}
MyComponent.register();
