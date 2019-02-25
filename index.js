import { AppRegistry } from 'react-native';
import App from './App';

AppRegistry.registerComponent('Test', () => App);

console.log("REGISTERING TASK");
AppRegistry.registerHeadlessTask('task', () => { console.log("SUCCESS!"); });
