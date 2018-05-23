import { NFC } from '@ionic-native/nfc';
import { Injectable } from '@angular/core';
import { LampMarkers } from '../ts/LampMarkers';

@Injectable()
export class nfcComponent {

  constructor(private nfc: NFC, private LampMarkers: LampMarkers) { }

  initNFC() {
    if (!this.nfc.enabled()) {
      alert("NFC is not enabled");
      return;
    }

    this.nfc.addNdefListener(() => { }, (err) => {
      console.log('error attaching ndef listener', err);
    }).subscribe(e => {
      for (let i in e.tag.ndefMessage) {
        let marker = this.LampMarkers.getLampMarker(e.tag.ndefMessage[i].tnf);
        if (marker == null) {
          continue;
        }
        this.LampMarkers.captureLamp(marker, marker.getMap());
        break;
      }

    }, err => {
      console.log("nfc error:", err);
    });
  }
}
