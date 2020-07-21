# Auto package audio plugins

inherit audio-plugin-common

PACKAGES =+ "${PN_DSSI} ${PN_LADSPA} ${PN_LV2} ${PN_VST} ${PN_VST3}"

FILES_${PN_DSSI} += "${libdir}/dssi"
FILES_${PN_LADSPA} += "${libdir}/ladspa"
FILES_${PN_LV2} += "${libdir}/lv2"
FILES_${PN_VST} += "${libdir}/vst"
FILES_${PN_VST3} += "${libdir}/vst3"
