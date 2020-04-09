SUMMARY = "GTK+ application that shows MIDI events"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=f1e8b3e96c0abf4e3abb3b0f8e8eaf7f"

inherit meson gtk-icon-cache

DEPENDS += " \
    gtk+ \
    jack \
"

SRC_URI = "git://github.com/schnitzeltony/gmidimonitor.git"
SRCREV = "d09b60906b31fcb7d5cd708e2e3745f1a585d630"
S = "${WORKDIR}/git"
