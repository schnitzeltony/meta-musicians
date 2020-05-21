SUMMARY = "Ganv is a Gtk widget for interactive graph-like environments"
DESCRIPTION = "Ganv is a Gtk widget for interactive graph-like environments, such as modular synthesizers or finite state machines"
HOMEPAGE = "http://drobilla.net/software/ganv"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit waf

DEPENDS += " \
    glib-2.0-native \
    gtk+ \
    gtkmm \
"

SRC_URI = " \
    gitsm://gitlab.com/drobilla/ganv.git;protocol=https \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "662bcbc0eceab2c3d4013efbd99861e451c8cf3b"
S = "${WORKDIR}/git"
PV = "1.6.0"
